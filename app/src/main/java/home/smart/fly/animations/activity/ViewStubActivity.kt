package home.smart.fly.animations.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import home.smart.fly.animations.R
import kotlinx.android.synthetic.main.activity_view_stub.*

class ViewStubActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_stub)
        load.setOnClickListener {
            var viewStub = stub.inflate()
            Toast.makeText(this, "ViewStub.inflate() consume only once !",Toast.LENGTH_SHORT).show()
            load.isEnabled = false
        }
    }
}
