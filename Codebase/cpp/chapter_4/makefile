CC = g++
CFLAGS = -I include -g -c -std=c++11 -Wall
LDFLAGS =
SRC = exercise6.cpp
OBJ = $(SRC:.cpp=.o)
EXEC = main

all: $(OBJ) $(EXEC)

$(EXEC): $(OBJ)
	$(CC) $(LDFLAGS) $(OBJ) -o $@

%.o: %.cpp
	$(CC) $(CFLAGS) -c $<

clean:
	rm -rf *.o core
