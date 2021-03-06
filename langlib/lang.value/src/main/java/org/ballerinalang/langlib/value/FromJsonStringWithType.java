/*
 *  Copyright (c) 2020, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package org.ballerinalang.langlib.value;

import org.ballerinalang.jvm.JSONParser;
import org.ballerinalang.jvm.api.BErrorCreator;
import org.ballerinalang.jvm.api.BStringUtils;
import org.ballerinalang.jvm.api.values.BString;
import org.ballerinalang.jvm.scheduling.Strand;
import org.ballerinalang.jvm.util.exceptions.BallerinaException;
import org.ballerinalang.jvm.values.TypedescValue;
import org.ballerinalang.model.types.TypeKind;
import org.ballerinalang.natives.annotations.Argument;
import org.ballerinalang.natives.annotations.BallerinaFunction;
import org.ballerinalang.natives.annotations.ReturnType;

import static org.ballerinalang.jvm.util.exceptions.BallerinaErrorReasons.VALUE_LANG_LIB_CONVERSION_ERROR;
import static org.ballerinalang.util.BLangCompilerConstants.VALUE_VERSION;

/**
 * Extern function lang.values:fromJsonWithType.
 * Converts a string in JSON format to a user-specified type.
 *
 * @since 2.0
 */
@BallerinaFunction(
        orgName = "ballerina",
        packageName = "lang.value", version = VALUE_VERSION,
        functionName = "fromJsonStringWithType",
        args = {
                @Argument(name = "str", type = TypeKind.STRING),
                @Argument(name = "t", type = TypeKind.TYPEDESC)
        },
        returnType = {
                @ReturnType(type = TypeKind.ANYDATA),
                @ReturnType(type = TypeKind.ERROR)
        },
        isPublic = true
)
public class FromJsonStringWithType {

    public static Object fromJsonStringWithType(Strand strand, BString value, TypedescValue t) {

        String str = value.getValue();
        try {
            if (str.equals("null")) {
                return FromJsonWithType.fromJsonWithType(strand, null, t);
            } else {
                Object jsonFromString = JSONParser.parse(str);
                return FromJsonWithType.fromJsonWithType(strand, jsonFromString, t);
            }
        } catch (BallerinaException e) {
            return BErrorCreator.createError(VALUE_LANG_LIB_CONVERSION_ERROR,
                                             BStringUtils.fromString(e.getMessage()));
        }
    }
}
