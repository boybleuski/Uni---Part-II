#ifndef NPC_SAM
#define NPC_SAM

#include <string>
#include <cstdlib>

using namespace std;

class NPC
{
public:
    NPC(string n_type, string n_sex, int n_age);
    NPC(string n_type, string n_name, string n_sex, string n_job, int n_age);
    void randomise();
    void specific(string n_type, string n_name, string n_sex, string n_job, string n_hair, string n_skin, string n_appearance, string n_bodyType, string n_personality, int n_age);
    string chooseHair(string type, string sex, int age, int seed);
    string chooseSkin(string type, string sex, int age, int seed);
    string chooseAppearance(string type, string sex, int age);
    string chooseBodyType(string type, string sex, int age, int seed);
    int chooseHeight(string type, string sex, int age);
    string choosePersonality(string type, string sex, int age, int seed);
    string chooseName(string type, string sex, int age, int seed);
    string chooseJob(string type, string sex, int age, int seed);
    void describe();

private:
    string type = "";
    string name = "";
    string sex = "";
    string job = "";
    string hair = "";
    string skin = "";
    string appearance = "";
    string bodyType = "";
    string personality = "";
    int age = 0;
    int height = 0;
};

#endif
