/*
 *  Copyright (c) 2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.ballerinalang.nativeimpl.internal;

import org.ballerinalang.bre.Context;
import org.ballerinalang.model.types.BServiceType;
import org.ballerinalang.model.values.BTypeValue;
import org.ballerinalang.model.values.BValue;
import org.ballerinalang.natives.annotations.BallerinaFunction;

/**
 * Get Service's Annotations.
 *
 * @since 0.965.0
 */
@BallerinaFunction(
        packageName = "ballerina.internal",
        functionName = "getServiceAnnotations"
)
public class GetServiceAnnotations extends AbstractAnnotationReader {

    @Override
    public BValue[] execute(Context context) {
        BTypeValue bTypeValue = (BTypeValue) getRefArgument(context, 0);
        if (!(bTypeValue.value() instanceof BServiceType)) {
            return new BValue[] {null};
        }
        BServiceType serviceType = (BServiceType) bTypeValue.value();
        return new BValue[] {getAnnotationValue(context, serviceType.getPackagePath(), serviceType.getName())};
    }
}
