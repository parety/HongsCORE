package io.github.ihongs.action.anno;

import io.github.ihongs.HongsException;
import io.github.ihongs.action.ActionHelper;
import io.github.ihongs.action.ActionRunner;
import io.github.ihongs.action.CommitRunner;
import java.lang.annotation.Annotation;

/**
 * 操作成功才提交数据更改
 *
 * 由Action.doAction自动调用
 *
 * @author Hongs
 */
public class CommitInvoker implements FilterInvoker {

    @Override
    public void invoke(ActionHelper helper, ActionRunner chains, Annotation anno)
    throws HongsException {
        // 为兼容 Java8 之前版本未使用函数式
        CommitRunner.run(new CommitRunner.Run() {
            public void run () throws Throwable {
                chains.doAction();
            }
        });
    }

}
