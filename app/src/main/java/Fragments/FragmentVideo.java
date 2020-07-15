package Fragments;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.kotevent.R;

//Renzo Cuadros Salazar
//Sergio Gamero Calle
//Gricel Ramos Ramos
public class FragmentVideo extends Fragment {
    VideoView videoView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.video_fragment,container,false);

        videoView = view.findViewById(R.id.video);
        String VideoPath = "android.resource://" + getActivity().getPackageName() + "/" + R.raw.presentacion;
        Uri uri = Uri.parse(VideoPath);
        videoView.setVideoURI(uri);

        MediaController mediaController = new MediaController(getContext());
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
        videoView.start();

        return view;
    }
}
