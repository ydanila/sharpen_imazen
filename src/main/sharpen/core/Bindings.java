/* Copyright (C) 2009  Versant Inc.   http://www.db4o.com */
package sharpen.core;

import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.IBinding;
import org.eclipse.jdt.core.dom.IMethodBinding;

public interface Bindings {

    IMethodBinding originalBindingFor(IMethodBinding binding);

    <T extends ASTNode> T findDeclaringNode(IBinding binding);

}
