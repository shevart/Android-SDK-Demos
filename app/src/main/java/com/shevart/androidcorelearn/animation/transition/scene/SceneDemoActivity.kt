package com.shevart.androidcorelearn.animation.transition.scene

import android.os.Bundle
import android.transition.Scene
import android.transition.TransitionManager
import com.shevart.androidcorelearn.R
import com.shevart.androidcorelearn.common.AbsActivity
import kotlinx.android.synthetic.main.activity_scene_demo.*

class SceneDemoActivity : AbsActivity() {
    private lateinit var sceneOne: Scene
    private lateinit var sceneTwo: Scene

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scene_demo)
        enableToolbarBackButton()

        sceneOne = Scene.getSceneForLayout(llSceneRoot, R.layout.layout_scene_one, this)
        sceneTwo = Scene.getSceneForLayout(llSceneRoot, R.layout.layout_scene_two, this)

        btSceneOne.setOnClickListener {
            TransitionManager.go(sceneOne)
        }
        btSceneTwo.setOnClickListener {
            TransitionManager.go(sceneTwo)
        }
    }
}
