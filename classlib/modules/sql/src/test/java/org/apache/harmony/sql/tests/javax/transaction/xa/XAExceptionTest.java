/* 
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.harmony.sql.tests.javax.transaction.xa;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;

import javax.transaction.xa.XAException;

import junit.framework.TestCase;

public class XAExceptionTest extends TestCase {

    /*
     * Public statics test
     */
    public void testPublicStatics() {

        HashMap<String, Integer> thePublicStatics = new HashMap<String, Integer>();
        thePublicStatics.put("XAER_OUTSIDE", new Integer(-9));
        thePublicStatics.put("XAER_DUPID", new Integer(-8));
        thePublicStatics.put("XAER_RMFAIL", new Integer(-7));
        thePublicStatics.put("XAER_PROTO", new Integer(-6));
        thePublicStatics.put("XAER_INVAL", new Integer(-5));
        thePublicStatics.put("XAER_NOTA", new Integer(-4));
        thePublicStatics.put("XAER_RMERR", new Integer(-3));
        thePublicStatics.put("XAER_ASYNC", new Integer(-2));
        thePublicStatics.put("XA_RDONLY", new Integer(3));
        thePublicStatics.put("XA_RETRY", new Integer(4));
        thePublicStatics.put("XA_HEURMIX", new Integer(5));
        thePublicStatics.put("XA_HEURRB", new Integer(6));
        thePublicStatics.put("XA_HEURCOM", new Integer(7));
        thePublicStatics.put("XA_HEURHAZ", new Integer(8));
        thePublicStatics.put("XA_NOMIGRATE", new Integer(9));
        thePublicStatics.put("XA_RBEND", new Integer(107));
        thePublicStatics.put("XA_RBTRANSIENT", new Integer(107));
        thePublicStatics.put("XA_RBTIMEOUT", new Integer(106));
        thePublicStatics.put("XA_RBPROTO", new Integer(105));
        thePublicStatics.put("XA_RBOTHER", new Integer(104));
        thePublicStatics.put("XA_RBINTEGRITY", new Integer(103));
        thePublicStatics.put("XA_RBDEADLOCK", new Integer(102));
        thePublicStatics.put("XA_RBCOMMFAIL", new Integer(101));
        thePublicStatics.put("XA_RBROLLBACK", new Integer(100));
        thePublicStatics.put("XA_RBBASE", new Integer(100));

        Class<?> xAExceptionClass;
        try {
            xAExceptionClass = Class
                    .forName("javax.transaction.xa.XAException");
        } catch (ClassNotFoundException e) {
            fail("javax.transaction.xa.XAException class not found!");
            return;
        } // end try

        Field[] theFields = xAExceptionClass.getDeclaredFields();
        int requiredModifier = Modifier.PUBLIC + Modifier.STATIC
                + Modifier.FINAL;

        int countPublicStatics = 0;
        for (Field element : theFields) {
            String fieldName = element.getName();
            int theMods = element.getModifiers();
            if (Modifier.isPublic(theMods) && Modifier.isStatic(theMods)) {
                try {
                    Object fieldValue = element.get(null);
                    Object expectedValue = thePublicStatics.get(fieldName);
                    if (expectedValue == null) {
                        fail("Field " + fieldName + " missing!");
                    } // end
                    assertEquals("Field " + fieldName + " value mismatch: ",
                            expectedValue, fieldValue);
                    assertEquals("Field " + fieldName + " modifier mismatch: ",
                            requiredModifier, theMods);
                    countPublicStatics++;
                } catch (IllegalAccessException e) {
                    fail("Illegal access to Field " + fieldName);
                } // end try
            } // end if
        } // end for

    } // end method testPublicStatics

    /*
     * ConstructorTest
     */
    public void testXAExceptionint() {

        int[] init1 = { -2147483648, 2147483647, 0, 1856939228, -217759650,
                -1808025128, -69857128 };

        String[] theFinalStates1 = { null, null, null, null, null, null, null };

        Exception[] theExceptions = { null, null, null, null, null, null, null };

        XAException aXAException;
        int loopCount = init1.length;
        for (int i = 0; i < loopCount; i++) {
            try {
                aXAException = new XAException(init1[i]);
                if (theExceptions[i] != null) {
                    fail();
                }
                assertEquals(i + "  Final state mismatch", aXAException
                        .getMessage(), theFinalStates1[i]);

            } catch (Exception e) {
                if (theExceptions[i] == null) {
                    fail(i + "Unexpected exception");
                }
                assertEquals(i + "Exception mismatch", e.getClass(),
                        theExceptions[i].getClass());
                assertEquals(i + "Exception mismatch", e.getMessage(),
                        theExceptions[i].getMessage());
            } // end try
        } // end for

    } // end method testXAExceptionint

    /*
     * ConstructorTest
     */
    public void testXAExceptionString() {

        String[] init1 = { "a", "1", "valid1", "----", "&valid*", null, "", " " };

        String[] theFinalStates1 = init1;

        Exception[] theExceptions = { null, null, null, null, null, null, null,
                null };

        XAException aXAException;
        int loopCount = init1.length;
        for (int i = 0; i < loopCount; i++) {
            try {
                aXAException = new XAException(init1[i]);
                if (theExceptions[i] != null) {
                    fail();
                }
                assertEquals(i + "  Final state mismatch", aXAException
                        .getMessage(), theFinalStates1[i]);

            } catch (Exception e) {
                if (theExceptions[i] == null) {
                    fail(i + "Unexpected exception");
                }
                assertEquals(i + "Exception mismatch", e.getClass(),
                        theExceptions[i].getClass());
                assertEquals(i + "Exception mismatch", e.getMessage(),
                        theExceptions[i].getMessage());
            } // end try
        } // end for

    } // end method testXAExceptionString

    /*
     * ConstructorTest
     */
    public void testXAException() {

        String[] theFinalStates1 = { null };

        Exception[] theExceptions = { null };

        XAException aXAException;
        int loopCount = 1;
        for (int i = 0; i < loopCount; i++) {
            try {
                aXAException = new XAException();
                if (theExceptions[i] != null) {
                    fail();
                }
                assertEquals(i + "  Final state mismatch", aXAException
                        .getMessage(), theFinalStates1[i]);

            } catch (Exception e) {
                if (theExceptions[i] == null) {
                    fail(i + "Unexpected exception");
                }
                assertEquals(i + "Exception mismatch", e.getClass(),
                        theExceptions[i].getClass());
                assertEquals(i + "Exception mismatch", e.getMessage(),
                        theExceptions[i].getMessage());
            } // end try
        } // end for

    } // end method testXAException

    /*
     * Public fields test
     */
    public void testPublicFields() {

        // Test values for the fields
        int testerrorCode = 1;

        // Constructor here...
        XAException aXAException = new XAException();

        // Set the field value...
        aXAException.errorCode = testerrorCode;

        // Run checks on field values
        assertEquals("Public field mismatch: ", aXAException.errorCode,
                testerrorCode);

    } // end method testPublicFields

} // end class XAExceptionTest
