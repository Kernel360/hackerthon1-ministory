package com.example.ministory.util;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum NotifyType {

	COMMENT(1, "댓글"), LIKE(2, "좋아요"), COMMENT_COMMENT(3, "대댓글");

		private final int code;
		private final String type;

		private NotifyType(int code, String type) {
			this.code = code;
			this.type = type;
		}

		public static NotifyType ofCode(int code) {
			return Arrays.stream(NotifyType.values())
							.filter(e -> e.getCode() == code)
							.findAny()
							.orElseThrow(() -> new NoSuchElementException());
			// TODO: 예외구문 넣기
		}

		public static NotifyType ofType(String type) {
			return Arrays.stream(NotifyType.values())
							.filter(e -> e.getType().equals(type))
							.findAny()
							.orElseThrow(() -> new NoSuchElementException());
			// TODO: 예외구문 넣기
		}

		public int getCode() {
			return this.code;
		}

		public String getType() {
			return this.type;
		}
}
