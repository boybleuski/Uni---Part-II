﻿using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class StageSelect : MonoBehaviour
{
    public void mainMenu()
    {
        SceneManager.LoadScene("TitleScreen");
    }

    public void startGame()
    {
        SceneManager.LoadScene("Stage1");
    }

    public void endGame()
    {
        Application.Quit();
    }
}
