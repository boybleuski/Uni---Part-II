CC=g++
CFLAGS=-c -Wall
SOURCES= Application.cpp
OBJECTS=$(SOURCES:.cpp=.o)
EXECUTABLE=Application

all: $(SOURCES) $(EXECUTABLE)

$(EXECUTABLE): $(OBJECTS)
	$(CC) $(OBJECTS) -o $@

%.o : %.cpp
	$(CC) $(CFLAGS) -c $<

clean:
	rm -rf *.o core
