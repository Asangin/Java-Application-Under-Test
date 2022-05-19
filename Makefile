.PHONY: db.run
db.run:
	docker-compose up db

.PHONY: service.run
service.run:
	./gradlew :service:bootRun

.PHONY: frontend.run
frontend.run:
	./gradlew :frontend:serve
