package com.amihaiemil.eoyaml;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

/**
 * Unit tests for {@link RtYamlInput}.
 * @author Mihai Andronache (amihaiemil@gmail.com)
 * @version $Id$
 * @since 1.0.1
 *
 */
public final class RtYamlInputTest {

    /**
     * YamlMapping can be read without its comments.
     * @throws Exception If something goes wrong
     */
    @Test
    public void readsMappingWithoutComments() throws Exception {
        YamlMapping expected = Yaml.createYamlMappingBuilder()
            .add("name", "eo-yaml")
            .add("architect", "mihai")
            .add("developers",
                Yaml.createYamlSequenceBuilder()
                    .add("rultor")
                    .add("salikjan")
                    .add("sherif")
                    .build()
            ).build();
        YamlMapping read = new RtYamlInput(
            new FileInputStream(
                new File("src/test/resources/commentedMapping.yml")
            )
        ).readYamlMapping();
        MatcherAssert.assertThat(
            read.string("name"),
            Matchers.equalTo(expected.string("name"))
        );
        MatcherAssert.assertThat(
            read.string("architect"),
            Matchers.equalTo(expected.string("architect"))
        );
        MatcherAssert.assertThat(
            read.yamlSequence("developers").size(),
            Matchers.equalTo(expected.yamlSequence("developers").size())
        );
        MatcherAssert.assertThat(
            read.yamlSequence("developers").string(0),
            Matchers.equalTo(expected.yamlSequence("developers").string(0))
        );
        MatcherAssert.assertThat(
            read.yamlSequence("developers").string(1),
            Matchers.equalTo(expected.yamlSequence("developers").string(1))
        );
        MatcherAssert.assertThat(
            read.yamlSequence("developers").string(2),
            Matchers.equalTo(expected.yamlSequence("developers").string(2))
        );
        MatcherAssert.assertThat(
            read, Matchers.equalTo(expected)
        );
    }
    
    /**
     * A YamlSequence in block style can be read.
     * @throws Exception If something goes wrong.
     */
    @Test
    public void readsBlockSequence() throws Exception {
        YamlSequence expected = Yaml.createYamlSequenceBuilder()
            .add("apples")
            .add("pears")
            .add("peaches")
            .build();
        
        YamlSequence read = new RtYamlInput(
            new ByteArrayInputStream(
                "- apples\n- pears\n- peaches".getBytes()
            )
        ).readYamlSequence();

        MatcherAssert.assertThat(read, Matchers.equalTo(expected));
    }
    
}
