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

run-dist-example:
	./gradlew run --args="src/test/resources/fixtures/file1.json  src/test/fixtures/resources/file2.json"

.PHONY:
	build
	test