/* ====================================================================
   Licensed to the Apache Software Foundation (ASF) under one or more
   contributor license agreements.  See the NOTICE file distributed with
   this work for additional information regarding copyright ownership.
   The ASF licenses this file to You under the Apache License, Version 2.0
   (the "License"); you may not use this file except in compliance with
   the License.  You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
==================================================================== */

package org.apache.poi.hsmf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

import org.apache.commons.io.output.UnsynchronizedByteArrayOutputStream;
import org.apache.poi.POIDataSamples;
import org.apache.poi.hsmf.datatypes.AttachmentChunks;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * Tests to verify that we can read attachments from msg file
 */
public class TestFileWithAttachmentsRead {
    private static MAPIMessage twoSimpleAttachments;
    private static MAPIMessage pdfMsgAttachments;
    private static MAPIMessage inlineImgMsgAttachments;

    /**
     * Initialize this test, load up the attachment_test_msg.msg mapi message.
     */
    @BeforeAll
    public static void setUp() throws IOException {
        POIDataSamples samples = POIDataSamples.getHSMFInstance();
        twoSimpleAttachments = new MAPIMessage(samples.openResourceAsStream("attachment_test_msg.msg"));
        pdfMsgAttachments = new MAPIMessage(samples.openResourceAsStream("attachment_msg_pdf.msg"));
        inlineImgMsgAttachments = new MAPIMessage(samples.openResourceAsStream("attachment_msg_inlineImg.msg"));
    }

    @AfterAll
    public static void tearDown() throws IOException {
        twoSimpleAttachments.close();
        pdfMsgAttachments.close();
        inlineImgMsgAttachments.close();
    }

    /**
     * Test to see if we can retrieve attachments.
     */
    @Test
    void testRetrieveAttachments() {
        // Simple file
        AttachmentChunks[] attachments = twoSimpleAttachments.getAttachmentFiles();
        assertEquals(2, attachments.length);

        // Other file
        attachments = pdfMsgAttachments.getAttachmentFiles();
        assertEquals(2, attachments.length);
    }

    /**
     * Bug 60550: Test to see if we get the correct Content-IDs of inline images`.
     */
    @ParameterizedTest
    @CsvSource({
        "0, image001.png@01D0A524.96D40F30",
        "1, image002.png@01D0A524.96D40F30",
        "2, image003.png@01D0A526.B4C739C0",
        "3, image006.jpg@01D0A526.B649E220"
    })
    void testReadContentIDField(int index, String contentId) {
        AttachmentChunks attachment = inlineImgMsgAttachments.getAttachmentFiles()[index];
        String fileName = contentId.substring(0, contentId.indexOf("@"));
        String extension = fileName.substring(fileName.lastIndexOf("."));

        assertEquals(fileName, attachment.getAttachFileName().getValue());
        assertEquals(extension, attachment.getAttachExtension().getValue());
        assertEquals(contentId, attachment.getAttachContentId().getValue());
    }


    /**
     * Test to see if attachments are not empty.
     */
    @Test
    void testReadAttachments() throws IOException {
        AttachmentChunks[] attachments = twoSimpleAttachments.getAttachmentFiles();

        // Basic checks
        for (AttachmentChunks attachment : attachments) {
            assertTrue(attachment.getAttachFileName().getValue().length() > 0);
            assertTrue(attachment.getAttachLongFileName().getValue().length() > 0);
            assertTrue(attachment.getAttachExtension().getValue().length() > 0);
            if (attachment.getAttachMimeTag() != null) {
                assertTrue(attachment.getAttachMimeTag().getValue().length() > 0);
            }
        }

        AttachmentChunks attachment;

        // Now check in detail
        attachment = twoSimpleAttachments.getAttachmentFiles()[0];
        assertEquals("TEST-U~1.DOC", attachment.getAttachFileName().getValue());
        assertEquals("test-unicode.doc", attachment.getAttachLongFileName().getValue());
        assertEquals(".doc", attachment.getAttachExtension().getValue());
        assertNull(attachment.getAttachMimeTag());
        UnsynchronizedByteArrayOutputStream attachmentstream = UnsynchronizedByteArrayOutputStream.builder().get();
        attachment.getAttachData().writeValue(attachmentstream);
        assertEquals(24064, attachmentstream.size());
        // or compare the hashes of the attachment data
        assertEquals(24064, attachment.getAttachData().getValue().length);

        attachment = twoSimpleAttachments.getAttachmentFiles()[1];
        assertEquals("pj1.txt", attachment.getAttachFileName().getValue());
        assertEquals("pj1.txt", attachment.getAttachLongFileName().getValue());
        assertEquals(".txt", attachment.getAttachExtension().getValue());
        assertNull(attachment.getAttachMimeTag());
        // or compare the hashes of the attachment data
        assertEquals(89, attachment.getAttachData().getValue().length);
        attachmentstream.reset();
        attachment.getAttachData().writeValue(attachmentstream);
        assertEquals(89, attachmentstream.size());
    }

    /**
     * Test that we can handle both PDF and MSG attachments
     */
    @Test
    void testReadMsgAttachments() throws Exception {
        AttachmentChunks[] attachments = pdfMsgAttachments.getAttachmentFiles();
        assertEquals(2, attachments.length);

        AttachmentChunks attachment;

        // Second is a PDF
        attachment = pdfMsgAttachments.getAttachmentFiles()[1];
        assertEquals("smbprn~1.pdf", attachment.getAttachFileName().getValue());
        assertEquals("smbprn.00009008.KdcPjl.pdf", attachment.getAttachLongFileName().getValue());
        assertEquals(".pdf", attachment.getAttachExtension().getValue());
        assertNull(attachment.getAttachMimeTag());
        assertNull(attachment.getAttachmentDirectory());
        //or compare the hashes of the attachment data
        assertEquals(13539, attachment.getAttachData().getValue().length);

        // First in a nested message
        attachment = pdfMsgAttachments.getAttachmentFiles()[0];
        assertEquals("Test Attachment", attachment.getAttachFileName().getValue());
        assertNull(attachment.getAttachLongFileName());
        assertNull(attachment.getAttachExtension());
        assertNull(attachment.getAttachMimeTag());
        assertNull(attachment.getAttachData());
        assertNotNull(attachment.getAttachmentDirectory());

        // Check we can see some bits of it
        MAPIMessage nested = attachment.getAttachmentDirectory().getAsEmbeddedMessage();
        assertEquals(1, nested.getRecipientNamesList().length);
        assertEquals("Nick Booth", nested.getRecipientNames());
        assertEquals("Test Attachment", nested.getConversationTopic());
    }
}
