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

package org.apache.poi.xdgf.util;

import java.awt.geom.AffineTransform;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.poi.xdgf.usermodel.XDGFPage;
import org.apache.poi.xdgf.usermodel.XDGFShape;
import org.apache.poi.xdgf.usermodel.XmlVisioDocument;
import org.apache.poi.xdgf.usermodel.shape.ShapeVisitor;

/**
 * Debugging tool useful when trying to figure out the hierarchy of the
 * shapes in a Visio diagram
 */
public class HierarchyPrinter {

    public static void printHierarchy(XDGFPage page, File outDir)
            throws FileNotFoundException, UnsupportedEncodingException, IOException {

        File pageFile = new File(outDir, "page" + page.getPageNumber() + "-"
                + Util.sanitizeFilename(page.getName()) + ".txt");

        try (
                OutputStream os = Files.newOutputStream(pageFile.toPath());
                PrintStream pos = new PrintStream(os, false, StandardCharsets.UTF_8.name())
            ) {
            printHierarchy(page, pos);
        }
    }

    public static void printHierarchy(XDGFPage page, final PrintStream os) {

        page.getContent().visitShapes(new ShapeVisitor() {

            @Override
            public void visit(XDGFShape shape, AffineTransform globalTransform,
                    int level) {
                for (int i = 0; i < level; i++) {
                    os.append("  ");
                }
                // TODO: write text?
                os.println(shape + " [" + shape.getShapeType()
                        + ", " + shape.getSymbolName() + "] "
                        + shape.getMasterShape() + " "
                        + shape.getTextAsString().trim());
            }
        });
    }

    public static void printHierarchy(XmlVisioDocument document,
            String outDirname) throws FileNotFoundException, UnsupportedEncodingException, IOException {

        File outDir = new File(outDirname);

        for (XDGFPage page : document.getPages()) {
            printHierarchy(page, outDir);
        }
    }

    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.err.println("Usage: in.vsdx outdir");
            System.exit(1);
        }

        String inFilename = args[0];
        String outDir = args[1];

        try (InputStream is = Files.newInputStream(Paths.get(inFilename))) {
            XmlVisioDocument doc = new XmlVisioDocument(is);
            printHierarchy(doc, outDir);
        }
    }
}
