build: lint test install

install:
	./gradlew clean
	./gradlew installDist

lint:
	./gradlew checkstyleMain
	./gradlew checkstyleTest

test:
	./gradlew test

run-dist:
	./build/install/app/bin/app

run-example:
	./gradlew run --args="-f json src/test/resources/fixtures/file1.yml  src/test/resources/fixtures/file2.yml"

.PHONY:
	build
	test