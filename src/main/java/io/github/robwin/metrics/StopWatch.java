/*
 *
 *  Copyright 2016 Robert Winkler
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 *
 */
package io.github.robwin.metrics;

import java.time.Duration;

/**
 * A simple {@link StopWatch} to measure the processing duration of a call.
 */
public class StopWatch {

    private final String id;
    private long startTime;
    private long elapsedTime;

    private StopWatch(String id){
        this.id = id;
        this.startTime = System.nanoTime();
    }

    public static StopWatch start(String id) {
        return new StopWatch(id);
    }

    public StopWatch stop() {
        this.elapsedTime = System.nanoTime() - startTime;
        return this;
    }

    public Duration getProcessingDuration() {
        return Duration.ofNanos(elapsedTime);
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString(){
        return String.format("Watch: '%s' Elapsed duration [ms]: '%s'", id, getProcessingDuration().toMillis());
    }
}
