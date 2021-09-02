package com.jvm.study;

import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatchers;

import java.lang.instrument.Instrumentation;

import static net.bytebuddy.matcher.ElementMatchers.named;

public class MasulsaAgent {
    public static void preMain(Instrumentation inst) {
        new AgentBuilder.Default()
                .type(ElementMatchers.any())
                .transform(
                        (builder, typeDescription, classLoader, javaModule) ->
                                builder.method(
                                        named("pullOut")
                                ).intercept(FixedValue.value("Justin!!")
                                )
                )
                .installOn(inst);
    }
}
