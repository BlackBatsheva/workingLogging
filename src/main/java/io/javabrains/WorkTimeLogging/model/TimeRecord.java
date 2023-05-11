
package io.javabrains.WorkTimeLogging.model;

import java.time.LocalDateTime;

    public record TimeRecord(
            LocalDateTime enterTime,
            LocalDateTime exitTime
    )
    {
}
