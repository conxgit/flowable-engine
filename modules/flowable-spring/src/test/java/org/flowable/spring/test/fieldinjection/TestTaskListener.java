/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.flowable.spring.test.fieldinjection;

import java.util.concurrent.atomic.AtomicInteger;

import org.flowable.engine.delegate.DelegateHelper;
import org.flowable.engine.delegate.TaskListener;
import org.flowable.task.service.delegate.DelegateTask;
import org.flowable.engine.common.api.delegate.Expression;
import org.springframework.stereotype.Component;

/**
 * @author Joram Barrez
 */
@Component("testTaskListener")
public class TestTaskListener implements TaskListener {

    public static AtomicInteger INSTANCE_COUNT = new AtomicInteger(0);
    
    protected Expression input;
    protected Expression resultVar;

    public TestTaskListener() {
        INSTANCE_COUNT.incrementAndGet();
    }

    @Override
    public void notify(DelegateTask delegateTask) {
        Expression inputExpression = DelegateHelper.getFieldExpression(delegateTask, "input");
        Number input = (Number) inputExpression.getValue(delegateTask);

        int result = input.intValue() / 2;

        Expression resultVarExpression = DelegateHelper.getFieldExpression(delegateTask, "resultVar");
        delegateTask.setVariable(resultVarExpression.getValue(delegateTask).toString(), result);
    }
    
}
