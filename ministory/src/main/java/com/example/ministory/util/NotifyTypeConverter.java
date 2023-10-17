package com.example.ministory.util;

import javax.persistence.AttributeConverter;

public class NotifyTypeConverter implements AttributeConverter<NotifyType, String> {

	@Override
	public String convertToDatabaseColumn(NotifyType notifyType) {
		return notifyType.getType();
	}

	@Override
		public NotifyType convertToEntityAttribute(String type) {
			return NotifyType.ofType(type);
		}

}

