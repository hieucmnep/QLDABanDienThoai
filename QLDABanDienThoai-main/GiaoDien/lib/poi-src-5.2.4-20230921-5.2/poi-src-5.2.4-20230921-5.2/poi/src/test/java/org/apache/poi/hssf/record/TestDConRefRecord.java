/*
 *  ====================================================================
 *    Licensed to the Apache Software Foundation (ASF) under one or more
 *    contributor license agreements.  See the NOTICE file distributed with
 *    this work for additional information regarding copyright ownership.
 *    The ASF licenses this file to You under the Apache License, Version 2.0
 *    (the "License"); you may not use this file except in compliance with
 *    the License.  You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 * ====================================================================
 */

package org.apache.poi.hssf.record;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.Arrays;

import org.apache.commons.io.output.UnsynchronizedByteArrayOutputStream;
import org.apache.poi.util.LittleEndianOutputStream;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for DConRefRecord class.
 */
class TestDConRefRecord {
    /**
     * record of a proper single-byte external 'volume'-style path with multiple parts and a sheet
     * name.
     */
    final byte[] volumeString = {
        0, 0, 0, 0, 0, 0, //ref (6 bytes) not used...
        17, 0,//cchFile (2 bytes)
        0, //char type
        1, 1, 'c', '[', 'f', 'o', 'o', 0x3,
        'b', 'a', 'r', ']', 's', 'h', 'e', 'e',
        't'
    };
    /**
     * record of a proper single-byte external 'unc-volume'-style path with multiple parts and a
     * sheet name.
     */
    final byte[] uncVolumeString = {
        0, 0, 0, 0, 0, 0, //ref (6 bytes) not used...
        34, 0,//cchFile (2 bytes)
        0, //char type
        1, 1, '@', '[', 'c', 'o', 'm', 'p',
        0x3, 's', 'h', 'a', 'r', 'e', 'd', 0x3,
        'r', 'e', 'l', 'a', 't', 'i', 'v', 'e',
        0x3, 'f', 'o', 'o', ']', 's', 'h', 'e',
        'e', 't'
    };
    /**
     * record of a proper single-byte external 'simple-file-path-dcon' style path with a sheet name.
     */
    final byte[] simpleFilePathDconString = {
        0, 0, 0, 0, 0, 0, //ref (6 bytes) not used...
        16, 0,//cchFile (2 bytes)
        0, //char type
        1, 'c', '[', 'f', 'o', 'o', 0x3, 'b',
        'a', 'r', ']', 's', 'h', 'e', 'e', 't'
    };
    /**
     * record of a proper 'transfer-protocol'-style path. This one has a sheet name at the end, and
     * another one inside the file path. The spec doesn't seem to care about what they are.
     */
    final byte[] transferProtocolString = {
        0, 0, 0, 0, 0, 0, //ref (6 bytes) not used...
        33, 0,//cchFile (2 bytes)
        0, //char type
        0x1, 0x5, 30, //count = 30
        '[', 'h', 't', 't', 'p', ':', '/', '/',
        '[', 'f', 'o', 'o', 0x3, 'b', 'a', 'r',
        ']', 's', 'h', 'e', 'e', 't', '1', ']',
        's', 'h', 'e', 'e', 't', 'x'
    };
    /**
     * startup-type path.
     */
    final byte[] relVolumeString = {
        0, 0, 0, 0, 0, 0, //ref (6 bytes) not used...
        16, 0,//cchFile (2 bytes)
        0, //char type
        0x1, 0x2, '[', 'f', 'o', 'o', 0x3, 'b',
        'a', 'r', ']', 's', 'h', 'e', 'e', 't'
    };
    /**
     * startup-type path.
     */
    final byte[] startupString = {
        0, 0, 0, 0, 0, 0, //ref (6 bytes) not used...
        16, 0,//cchFile (2 bytes)
        0, //char type
        0x1, 0x6, '[', 'f', 'o', 'o', 0x3, 'b',
        'a', 'r', ']', 's', 'h', 'e', 'e', 't'
    };
    /**
     * alt-startup-type path.
     */
    final byte[] altStartupString = {
        0, 0, 0, 0, 0, 0, //ref (6 bytes) not used...
        16, 0,//cchFile (2 bytes)
        0, //char type
        0x1, 0x7, '[', 'f', 'o', 'o', 0x3, 'b',
        'a', 'r', ']', 's', 'h', 'e', 'e', 't'
    };
    /**
     * library-style path.
     */
    final byte[] libraryString = {
        0, 0, 0, 0, 0, 0, //ref (6 bytes) not used...
        16, 0,//cchFile (2 bytes)
        0, //char type
        0x1, 0x8, '[', 'f', 'o', 'o', 0x3, 'b',
        'a', 'r', ']', 's', 'h', 'e', 'e', 't'
    };
    /**
     * record of single-byte string, external, volume path.
     */
    final byte[] data1 = {
        0, 0, 0, 0, 0, 0, //ref (6 bytes) not used...
        10, 0,//cchFile (2 bytes)
        0, //char type
        1, 1, (byte) 'b', (byte) 'l', (byte) 'a', (byte) ' ', (byte) 't',
        (byte) 'e', (byte) 's', (byte) 't'
    //unused doesn't exist as stFile[1] != 2
    };
    /**
     * record of double-byte string, self-reference.
     */
    final byte[] data2 = {
        0, 0, 0, 0, 0, 0, //ref (6 bytes) not used...
        9, 0,//cchFile (2 bytes)
        1, //char type = unicode
        2, 0, (byte) 'b', 0, (byte) 'l', 0, (byte) 'a', 0, (byte) ' ', 0, (byte) 't', 0,
        (byte) 'e', 0, (byte) 's', (byte) 't', 0,//stFile
        0, 0 //unused (2 bytes as we're using double-byte chars)
    };
    /**
     * record of single-byte string, self-reference.
     */
    final byte[] data3 = {
        0, 0, 0, 0, 0, 0, //ref (6 bytes) not used...
        9, 0,//cchFile (2 bytes)
        0, //char type = ansi
        2, (byte) 'b', (byte) 'l', (byte) 'a', (byte) ' ', (byte) 't', (byte) 'e', (byte) 's',
        (byte) 't',//stFile
        0 //unused (1 byte as we're using single byes)
    };
    /**
     * double-byte string, external reference, unc-volume.
     */
    final byte[] data4 = {
        0, 0, 0, 0, 0, 0, //ref (6 bytes) not used...
        16, 0,//cchFile (2 bytes)
        //stFile starts here:
        1, //char type = unicode
        1, 0, 1, 0, 0x40, 0, (byte) 'c', 0, (byte) 'o', 0, (byte) 'm', 0, (byte) 'p', 0, 0x03, 0,
        (byte) 'b', 0, (byte) 'l', 0, (byte) 'a', 0, 0x03, 0, (byte) 't', 0, (byte) 'e', 0,
        (byte) 's', 0, (byte) 't', 0,
    //unused doesn't exist as stFile[1] != 2
    };

    /**
     * test read-constructor-then-serialize for a single-byte external reference strings of
     * various flavours. This uses the RecordInputStream constructor.
     */
    @Test
    void testReadWriteSBExtRef() throws IOException {
        testReadWrite(data1, "read-write single-byte external reference, volume type path");
        testReadWrite(volumeString,
                "read-write properly formed single-byte external reference, volume type path");
        testReadWrite(uncVolumeString,
                "read-write properly formed single-byte external reference, UNC volume type path");
        testReadWrite(relVolumeString,
                "read-write properly formed single-byte external reference, rel-volume type path");
        testReadWrite(simpleFilePathDconString,
                "read-write properly formed single-byte external reference, simple-file-path-dcon type path");
        testReadWrite(transferProtocolString,
                "read-write properly formed single-byte external reference, transfer-protocol type path");
        testReadWrite(startupString,
                "read-write properly formed single-byte external reference, startup type path");
        testReadWrite(altStartupString,
                "read-write properly formed single-byte external reference, alt-startup type path");
        testReadWrite(libraryString,
                "read-write properly formed single-byte external reference, library type path");
    }

    /**
     * test read-constructor-then-serialize for a double-byte external reference 'UNC-Volume' style
     * string
     */
    @Test
    void testReadWriteDBExtRefUncVol() throws IOException {
        testReadWrite(data4, "read-write double-byte external reference, UNC volume type path");
    }

    private void testReadWrite(byte[] data, String message) throws IOException {
        RecordInputStream is = TestcaseRecordInputStream.create(81, data);
        DConRefRecord d = new DConRefRecord(is);
        UnsynchronizedByteArrayOutputStream bos = UnsynchronizedByteArrayOutputStream.builder().setBufferSize(data.length).get();
        LittleEndianOutputStream o = new LittleEndianOutputStream(bos);
        d.serialize(o);
        o.flush();

        assertArrayEquals(data, bos.toByteArray(), message);
    }

    /**
     * test read-constructor-then-serialize for a double-byte self-reference style string
     */
    @Test
    void testReadWriteDBSelfRef() throws IOException {
        testReadWrite(data2, "read-write double-byte self reference");
    }

    /**
     * test read-constructor-then-serialize for a single-byte self-reference style string
     */
    @Test
    void testReadWriteSBSelfRef() throws IOException {
        testReadWrite(data3, "read-write single byte self reference");
    }

    /**
     * Test of getDataSize method, of class DConRefRecord.
     */
    @Test
    void testGetDataSize() {
        DConRefRecord instance = new DConRefRecord(TestcaseRecordInputStream.create(81, data1));
        int expResult = data1.length;
        int result = instance.getDataSize();
        assertEquals(expResult, result, "single byte external reference, volume type path data size");
        instance = new DConRefRecord(TestcaseRecordInputStream.create(81, data2));
        assertEquals(data2.length, instance.getDataSize(), "double byte self reference data size");
        instance = new DConRefRecord(TestcaseRecordInputStream.create(81, data3));
        assertEquals(data3.length, instance.getDataSize(), "single byte self reference data size");
        instance = new DConRefRecord(TestcaseRecordInputStream.create(81, data4));
        assertEquals(data4.length, instance.getDataSize(),
            "double byte external reference, UNC volume type path data size");
    }

    /**
     * Test of getSid method, of class DConRefRecord.
     */
    @Test
    void testGetSid() {
        DConRefRecord instance = new DConRefRecord(TestcaseRecordInputStream.create(81, data1));
        short expResult = 81;
        short result = instance.getSid();
        assertEquals(expResult, result, "SID");
    }

    /**
     * Test of getPath method, of class DConRefRecord.
     */
    @Test
    void testGetPath() {
        // TODO: different types of paths.
        DConRefRecord instance = new DConRefRecord(TestcaseRecordInputStream.create(81, data1));
        byte[] expResult = Arrays.copyOfRange(data1, 9, data1.length);
        byte[] result = instance.getPath();
        assertArrayEquals(expResult, result, "get path");
    }

    /**
     * Test of isExternalRef method, of class DConRefRecord.
     */
    @Test
    void testIsExternalRef() {
        DConRefRecord instance = new DConRefRecord(TestcaseRecordInputStream.create(81, data1));
        assertTrue(instance.isExternalRef(), "external reference");
        instance = new DConRefRecord(TestcaseRecordInputStream.create(81, data2));
        assertFalse(instance.isExternalRef(), "internal reference");
    }
}
