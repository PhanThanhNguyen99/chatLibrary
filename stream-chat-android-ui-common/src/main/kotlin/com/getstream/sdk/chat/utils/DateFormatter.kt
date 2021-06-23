package com.getstream.sdk.chat.utils

import android.content.Context
import io.getstream.chat.android.core.internal.InternalStreamChatApi
import org.threeten.bp.LocalDateTime
import org.threeten.bp.LocalTime
import java.util.Date

public interface DateFormatter {
    public fun formatDate(localDateTime: LocalDateTime?): String
    public fun formatTime(localTime: LocalTime?): String

    public companion object {
        @JvmStatic
        public fun from(context: Context): DateFormatter = DefaultDateFormatter(context)
    }
}

/**
 * Extension to be able to format objects of the deprecated [Date] type.
 */
@InternalStreamChatApi
public fun DateFormatter.formatDate(date: Date?): String {
    return formatDate(date?.let(DateConverter::toLocalDateTime))
}

/**
 * Extension to be able to format objects of the deprecated [Date] type.
 */
@InternalStreamChatApi
public fun DateFormatter.formatTime(date: Date?): String {
    return formatTime(date?.let(DateConverter::toLocalTime))
}
