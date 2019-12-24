/* Copyright (C) 2009  Versant Inc.   http://www.db4o.com */
package sharpen.core.internal;

import org.eclipse.jdt.core.dom.AbstractTypeDeclaration;
import org.eclipse.jdt.core.dom.EnumDeclaration;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import sharpen.core.Mappings;
import sharpen.core.NameScope;
import sharpen.core.SharpenAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static sharpen.core.framework.Environments.my;

public class NameScopeImpl implements NameScope {


    public boolean contains(String name) {
        return _mappedMethodDeclarations.contains(name);
    }

    public void enterTypeDeclaration(AbstractTypeDeclaration node) {
        _currentType.push(node);

        _mappedMethodDeclarations.clear();
        for (MethodDeclaration meth : getMethods(node)) {
            if (SharpenAnnotations.hasIgnoreAnnotation(meth))
                continue;

            _mappedMethodDeclarations.add(my(Mappings.class).mappedMethodName(meth.resolveBinding()));
        }
    }

    public void leaveTypeDeclaration(AbstractTypeDeclaration node) {
        _currentType.pop();
    }

    public AbstractTypeDeclaration currentType() {
        return _currentType.peek();
    }

    private static MethodDeclaration[] getMethods(AbstractTypeDeclaration node) {
        if (node instanceof TypeDeclaration) {
            return ((TypeDeclaration) node).getMethods();
        } else if (node instanceof EnumDeclaration) {
            List<MethodDeclaration> methodsList = new ArrayList<MethodDeclaration>();
            for (Object declaration : node.bodyDeclarations()) {
                if (declaration instanceof MethodDeclaration) {
                    methodsList.add((MethodDeclaration) declaration);
                }
            }

            return methodsList.toArray(new MethodDeclaration[methodsList.size()]);
        } else {
            throw new UnsupportedOperationException("not implemented");
        }
    }

    private Stack<AbstractTypeDeclaration> _currentType = new Stack();
    private List<String> _mappedMethodDeclarations = new ArrayList<String>();
}
