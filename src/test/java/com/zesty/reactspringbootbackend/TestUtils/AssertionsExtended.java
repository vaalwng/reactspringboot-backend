package com.zesty.reactspringbootbackend.TestUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;

public interface AssertionsExtended {

    private static void verifySerdes(ObjectMapper mapper, Object object, String json) throws IOException {
        String serialized = mapper.writeValueAsString(object);
        Assertions.assertEquals(json, serialized);
        Object deserialized = mapper.readValue(serialized, object.getClass());
        Assertions.assertEquals(object, deserialized);
    }

    static void verifySerdes(Object object, String json) throws IOException {
        verifySerdes(new ObjectMapper(), object, json);
    }

    static void verifyEqualsAndHashCode(Object instanceA, Object instanceB) {
        MatcherAssert.assertThat(instanceA, Matchers.equalTo(instanceA));
        MatcherAssert.assertThat(instanceB, Matchers.equalTo(instanceB));
        MatcherAssert.assertThat(instanceA, Matchers.equalTo(instanceB));
        MatcherAssert.assertThat(instanceB, Matchers.equalTo(instanceA));
        MatcherAssert.assertThat(instanceA.hashCode(), Matchers.equalTo(instanceA.hashCode()));
        MatcherAssert.assertThat(instanceB.hashCode(), Matchers.equalTo(instanceB.hashCode()));
        MatcherAssert.assertThat(instanceA.hashCode(), Matchers.equalTo(instanceB.hashCode()));
        MatcherAssert.assertThat(instanceB.hashCode(), Matchers.equalTo(instanceA.hashCode()));
    }

    private static void verifySerialization(ObjectMapper mapper, Object object, String expectedJson) throws IOException {
        Assertions.assertEquals(expectedJson, mapper.writeValueAsString(object));
    }

    static void verifySerialization(Object object, String expectedJson) throws IOException {
        verifySerialization(new ObjectMapper(), object, expectedJson);
    }

    static void verifyDeserialization(String json, Object expectedObject) throws IOException {
        verifyDeserialization(new ObjectMapper(), json, expectedObject);
    }

    private static void verifyDeserialization(ObjectMapper mapper, String json, Object expectedObject) throws IOException {
        Assertions.assertEquals(expectedObject, mapper.readValue(json, expectedObject.getClass()));
    }

    static void verifyToString(String expected, Object obj) {
        Assertions.assertEquals(expected, obj.toString());
    }

}