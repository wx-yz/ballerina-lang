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
package io.ballerinalang.compiler.internal.parser.tree;

import io.ballerinalang.compiler.syntax.tree.Node;
import io.ballerinalang.compiler.syntax.tree.NonTerminalNode;
import io.ballerinalang.compiler.syntax.tree.SyntaxKind;

import java.util.Collection;

/**
 * Represents the parent node of an {@code STToken} attached to an {@code STInvalidNodeMinutiae} node.
 *
 * @since 2.0.0
 */
public class STInvalidTokenMinutiaeNode extends STNode {
    public final STToken token;

    STInvalidTokenMinutiaeNode(STToken token) {
        super(SyntaxKind.INVALID_TOKEN_MINUTIAE_NODE);
        this.token = token;
        addChildren(token);
    }

    @Override
    public STNode modifyWith(Collection<STNodeDiagnostic> diagnostics) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Node createFacade(int position, NonTerminalNode parent) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void accept(STNodeVisitor visitor) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <T> T apply(STNodeTransformer<T> transformer) {
        throw new UnsupportedOperationException();
    }
}
