package org.envision.trash_it;

import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.VideoView;

import android.app.Fragment;

public class FragmentHome extends Fragment {

    public static FragmentHome newInstance() {

        return new FragmentHome();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment



        View view=inflater.inflate(R.layout.fragment_home, container, false);
//        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
//
        //Typeface tfArial = Typeface.createFromAsset(getActivity().getAssets(), "arial.ttf");
        TextView tv = view.findViewById(R.id.title);
// find the textview id from layout or create dynamically
       // tv.setTypeface(tfArial);

        VideoView mVideoView = (VideoView) view.findViewById(R.id.video);

        Uri uri = Uri.parse("android.resource://"+getActivity().getPackageName()+"/"+R.raw.aboutvideo);

        mVideoView.setVideoURI(uri);
        mVideoView.start();

        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer)
            {
                mediaPlayer.setLooping(true);
            }
        });
        return view;
    }
}
