package com.example.RateLimiter;

import com.example.FileTaggingSystem.FileTagging;
import com.example.RateLimiter.LoggerRateLimiter.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class RateLimiterApplicationTests {


	@Test
	public void testShouldPrintMessage() {
		Logger logger = new Logger();

		assert logger.shouldPrintMessage(1, "foo");
		assert logger.shouldPrintMessage(3, "bar");
		assert logger.shouldPrintMessage(4, "xyz");
		assert !logger.shouldPrintMessage(10, "foo");
		assert logger.shouldPrintMessage(11, "foo");
		assert logger.shouldPrintMessage(13, "bar");
	}

	@Test
	public void testGroupFilesByTags() {

		List<FileTagging.File> files = Arrays.asList(
				new FileTagging.File("file1.text", Arrays.asList("tag1", "tag2"), 100),
				new FileTagging.File("file2.text", Arrays.asList("tag2", "tag3"), 150),
				new FileTagging.File("file3.text", Arrays.asList("tag1", "tag3"), 120)
		);

		List<String> topTags = FileTagging.groupFilesByTags(files, 2);

		List<String> expectedTags = Arrays.asList("tag2", "tag3");

		assert expectedTags.equals(topTags);

	}

}
