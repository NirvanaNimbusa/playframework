package com.lightbend.play.tools.javascript;

import java.io.File;

public abstract class StaleClassCleaner {
    public abstract void execute();

    public abstract void addDirToClean(File toClean);
}
