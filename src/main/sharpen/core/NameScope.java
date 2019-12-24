/* Copyright (C) 2009  Versant Inc.   http://www.db4o.com */
package sharpen.core;

import org.eclipse.jdt.core.dom.AbstractTypeDeclaration;

public interface NameScope {

    void enterTypeDeclaration(AbstractTypeDeclaration node);

    void leaveTypeDeclaration(AbstractTypeDeclaration node);

    AbstractTypeDeclaration currentType();

    boolean contains(String name);

}
