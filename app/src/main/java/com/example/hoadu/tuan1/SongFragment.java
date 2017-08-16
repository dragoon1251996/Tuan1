package com.example.hoadu.tuan1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.hoadu.adapter.SongAdapter;
import com.example.hoadu.enity.Song;
import com.example.hoadu.interfaceadapter.SongInterFace;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hoadu on 19/04/2017.
 */

public class SongFragment extends Fragment  implements SongInterFace{
    private RecyclerView rvSongs;
    private SongAdapter mSongAdapter;
    private List<Song> mSongs;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_song,container,false);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        rvSongs= (RecyclerView) getActivity().findViewById(R.id.rv_song);
        mSongs=new ArrayList<>();
        initData();
        mSongAdapter = new SongAdapter(getActivity(),  mSongs,this);
        rvSongs.setAdapter(mSongAdapter);
//        RecyclerView scroll vertical
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        rvSongs.setLayoutManager(linearLayoutManager);

    }
    private void initData() {
        mSongs.add(new Song("60696", "NẾU EM CÒN TỒN TẠI", "Khi anh bắt đầu một tình yêu Là lúc anh tự thay", "Trịnh Đình Quang"));
        mSongs.add(new Song("60701", "NGỐC", "Có rất nhiều những câu chuyện Em dấu riêng mình em biết", "Khắc Việt"));
        mSongs.add(new Song("60650", "HÃY TIN ANH LẦN NỮA", "Dẫu cho ta đã sai khi ở bên nhau Cô yêu thương", "Thiên Dũng"));
        mSongs.add(new Song("60610", "CHUỖI NGÀY VẮNG EM", "Từ khi em bước ra đi cõi lòng anh ngập tràng bao", "Duy Cường"));
        mSongs.add(new Song("60656", "KHI NGƯỜI MÌNH YÊU KHÓC", "Nước mắt em đang rơi trên những ngón tay Nước mắt em", "Phạm Mạnh Quỳnh"));
        mSongs.add(new Song("60685", "MỞ", "Anh mơ gặp em anh mơ được ôm anh mơ được gần", "Trịnh Thăng Bình"));
        mSongs.add(new Song("60752", "TÌNH YÊU CHẮP VÁ", "Muốn đi xa nơi yêu thương mình từng có Để không nghe", "Mr. Siro"));
        mSongs.add(new Song("60608", "CHỜ NGÀY MƯA TAN", "Một ngày mưa và em khuất xa nơi anh bóng dáng cứ", "Trung Đức"));
        mSongs.add(new Song("60603", "CÂU HỎI EM CHƯA TRẢ LỜI", "Cần nơi em một lời giải thích thật lòng Đừng lặng im", "Yuki Huy Nam"));
        mSongs.add(new Song("60720", "QUA ĐI LẶNG LẼ", "Đôi khi đến với nhau yêu thương chẳng được lâu nhưng khi", "Phan Mạnh Quỳnh"));
        mSongs.add(new Song("60856", "QUÊN ANH LÀ ĐIỀU EM KHÔNG THỂ - REMIX", "Cần thêm bao lâu để em quên đi niềm đâu Cần thêm", "Thiện Ngôn"));
        mSongs.add(new Song("60696", "NẾU EM CÒN TỒN TẠI", "Khi anh bắt đầu một tình yêu Là lúc anh tự thay", "Trịnh Đình Quang"));
        mSongs.add(new Song("60701", "NGỐC", "Có rất nhiều những câu chuyện Em dấu riêng mình em biết", "Khắc Việt"));
        mSongs.add(new Song("60650", "HÃY TIN ANH LẦN NỮA", "Dẫu cho ta đã sai khi ở bên nhau Cô yêu thương", "Thiên Dũng"));
        mSongs.add(new Song("60610", "CHUỖI NGÀY VẮNG EM", "Từ khi em bước ra đi cõi lòng anh ngập tràng bao", "Duy Cường"));
        mSongs.add(new Song("60656", "KHI NGƯỜI MÌNH YÊU KHÓC", "Nước mắt em đang rơi trên những ngón tay Nước mắt em", "Phạm Mạnh Quỳnh"));
        mSongs.add(new Song("60685", "MỞ", "Anh mơ gặp em anh mơ được ôm anh mơ được gần", "Trịnh Thăng Bình"));
        mSongs.add(new Song("60696", "NẾU EM CÒN TỒN TẠI", "Khi anh bắt đầu một tình yêu Là lúc anh tự thay", "Trịnh Đình Quang"));
        mSongs.add(new Song("60701", "NGỐC", "Có rất nhiều những câu chuyện Em dấu riêng mình em biết", "Khắc Việt"));
        mSongs.add(new Song("60650", "HÃY TIN ANH LẦN NỮA", "Dẫu cho ta đã sai khi ở bên nhau Cô yêu thương", "Thiên Dũng"));
        mSongs.add(new Song("60610", "CHUỖI NGÀY VẮNG EM", "Từ khi em bước ra đi cõi lòng anh ngập tràng bao", "Duy Cường"));
        mSongs.add(new Song("60656", "KHI NGƯỜI MÌNH YÊU KHÓC", "Nước mắt em đang rơi trên những ngón tay Nước mắt em", "Phạm Mạnh Quỳnh"));
        mSongs.add(new Song("60685", "MỞ", "Anh mơ gặp em anh mơ được ôm anh mơ được gần", "Trịnh Thăng Bình"));
    }

    @Override
    public void tenBai(String tenBai) {
        Toast.makeText(getContext(),tenBai,Toast.LENGTH_SHORT).show();
    }
}
