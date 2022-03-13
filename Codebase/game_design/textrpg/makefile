CC = g++
CFLAGS = -I include -g -c -std=c++11 -Wall
LDFLAGS =
SRC = main.cpp NPC.cpp
OBJ = $(SRC:.cpp=.o)
EXEC = game

all: $(OBJ) $(EXEC)

$(EXEC): $(OBJ)
	$(CC) $(LDFLAGS) $(OBJ) -o $@

%.o: %.cpp
	$(CC) $(CFLAGS) -c $<

clean:
	rm -rf *.o core
