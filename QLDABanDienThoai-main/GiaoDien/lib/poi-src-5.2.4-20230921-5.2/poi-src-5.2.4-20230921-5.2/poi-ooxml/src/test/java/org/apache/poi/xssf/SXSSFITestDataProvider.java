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

package org.apache.poi.xssf;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.io.output.UnsynchronizedByteArrayOutputStream;
import org.apache.poi.POIDataSamples;
import org.apache.poi.ss.ITestDataProvider;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SXSSFITestDataProvider implements ITestDataProvider {
    public static final SXSSFITestDataProvider instance = new SXSSFITestDataProvider();

    // an instance of all SXSSFWorkbooks opened by this TestDataProvider,
    // so that the temporary files created can be disposed up by cleanup()
    protected final Collection<SXSSFWorkbook> instances = new ArrayList<>();

    protected SXSSFITestDataProvider() {
        // enforce singleton
    }

    @Override
    public Workbook openSampleWorkbook(String sampleFileName) {
        XSSFWorkbook xssfWorkbook = XSSFITestDataProvider.instance.openSampleWorkbook(sampleFileName);
        SXSSFWorkbook swb = new SXSSFWorkbook(xssfWorkbook);
        instances.add(swb);
        return swb;
    }

    /**
     * Returns an XSSFWorkbook since SXSSFWorkbook is write-only
     */
    @Override
    public XSSFWorkbook writeOutAndReadBack(Workbook wb) {
        // wb is usually an SXSSFWorkbook, but must also work on an XSSFWorkbook
        // since workbooks must be able to be written out and read back
        // several times in succession
        if(!(wb instanceof SXSSFWorkbook || wb instanceof XSSFWorkbook)) {
            throw new IllegalArgumentException("Expected an instance of SXSSFWorkbook");
        }

        try (UnsynchronizedByteArrayOutputStream baos = UnsynchronizedByteArrayOutputStream.builder().get()) {
            wb.write(baos);
            try (InputStream is = baos.toInputStream()) {
                return new XSSFWorkbook(is);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public SXSSFWorkbook createWorkbook() {
        SXSSFWorkbook wb = new SXSSFWorkbook();
        instances.add(wb);
        return wb;
    }

    //************ SXSSF-specific methods ***************//
    @Override
    public SXSSFWorkbook createWorkbook(int rowAccessWindowSize) {
        SXSSFWorkbook wb = new SXSSFWorkbook(rowAccessWindowSize);
        instances.add(wb);
        return wb;
    }

    @Override
    public void trackAllColumnsForAutosizing(Sheet sheet) {
        ((SXSSFSheet)sheet).trackAllColumnsForAutoSizing();
    }
    //************ End SXSSF-specific methods ***************//

    @Override
    public FormulaEvaluator createFormulaEvaluator(Workbook wb) {
        return new XSSFFormulaEvaluator(((SXSSFWorkbook) wb).getXSSFWorkbook());
    }

    @Override
    public byte[] getTestDataFileContent(String fileName) {
        return POIDataSamples.getSpreadSheetInstance().readFile(fileName);
    }

    @Override
    public SpreadsheetVersion getSpreadsheetVersion() {
        return SpreadsheetVersion.EXCEL2007;
    }

    @Override
    public String getStandardFileNameExtension() {
        return "xlsx";
    }

    public synchronized boolean cleanup() {
        boolean ok = true;
        for(final SXSSFWorkbook wb : instances) {
            ok = ok && wb.dispose();
        }
        instances.clear();
        return ok;
    }
}
