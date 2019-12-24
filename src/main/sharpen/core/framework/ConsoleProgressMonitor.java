/**
 *
 */
package sharpen.core.framework;

import org.eclipse.core.runtime.NullProgressMonitor;

public class ConsoleProgressMonitor extends NullProgressMonitor {
    public void subTask(String name) {
        System.out.println(name);
    }
}