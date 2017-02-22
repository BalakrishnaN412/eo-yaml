package com.amihaiemil.camel;

import java.util.Collection;

/**
 * YamlSequence read from somewhere.
 * @author Mihai Andronache (amihaiemil@gmail.com)
 * @version $Id$
 * @since 1.0.0
 * @todo #64:30min/DEV Continue implementing and unit testing the methods 
 *  from this class one by one.
 */
final class ReadYamlSequence implements YamlSequence {

    /**
     * Lines read.
     */
    private AbstractYamlLines lines;

    /**
     * Ctor.
     * @param lines Given lines.
     */
    ReadYamlSequence(final AbstractYamlLines lines) {
        this.lines = lines;
    }

    @Override
    public Collection<YamlNode> children() {
        return null;
    }

    @Override
    public String indent(final int indentation) {
        return null;
    }

    @Override
    public int compareTo(final YamlNode other) {
        return 0;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public YamlMapping yamlMapping(final int index) {
        return null;
    }

    @Override
    public YamlSequence yamlSequence(final int index) {
        return null;
    }

    @Override
    public String string(final int index) {
        return null;
    }

}