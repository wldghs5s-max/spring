package com.kh.app.member;

import com.kh.app.util.FileUploader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {
    private final MemberMapper memberMapper;
    @Value("${file.upload.path.member}")
    private String filePath;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    public int join(MemberVo vo, MultipartFile profile) throws IOException {
        //valid
        checkValidation(vo);

        //save file
        //파일을 서버에 저장
        if(profile!=null && !profile.isEmpty()){
            String changeName = FileUploader.upload(profile , filePath);
            vo.setProfileChangeName(changeName);
            vo.setProfileOriginName(profile.getOriginalFilename());
        }
        //encrypt
        String encodedPw = bCryptPasswordEncoder.encode(vo.getPw());
        vo.setPw(encodedPw);


        return memberMapper.join(vo);
    }

    private void checkValidation(MemberVo vo) {
        checkIdValid(vo.getId());
        checkPwValid(vo.getPw());
        checkNickValid(vo.getNick());
    }

    private void checkIdValid(String id) {
        if(id.length() >= 4 && id.length() <=12){
            return;
        }else {
            throw new IllegalArgumentException("[M-101] id length");
        }
    }

    private void checkPwValid(String pw) {
        if(pw.length() >= 4 && pw.length() <=12){
            return;
        }else {
            throw new IllegalArgumentException("[M-102] pw length");
        }
    }

    private void checkNickValid(String nick) {
        if(nick.length() >= 2 && nick.length() <=12){
            return;
        }else {
            throw new IllegalArgumentException("[M-103] nick length");
        }
    }

    public List<HobbyVo> selectHobbyList() {
        return memberMapper.selectHobbyList();
    }

    public MemberVo login(MemberVo vo) {
        MemberVo dbVo = memberMapper.selectById(vo.getId());
        boolean isMatch = bCryptPasswordEncoder.matches(vo.getPw(), dbVo.getPw());
        return isMatch ? dbVo : null;
    }

    public int quit(String no) {
        return memberMapper.quit(no);
    }
}
