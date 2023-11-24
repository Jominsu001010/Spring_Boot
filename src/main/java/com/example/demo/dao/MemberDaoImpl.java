package com.example.demo.dao;

import com.example.demo.domain.FortuneDO;
import com.example.demo.domain.Member;
import com.example.demo.domain.MemberDO;
import com.example.demo.domain.NotifyDO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberDaoImpl implements MemberDao{
    private String driver = "oracle.jdbc.driver.OracleDriver";
    private String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
    private String userName = "NEWLEC";
    private String password = "1234";

    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;
    /*public MemberDaoImpl(String driver, String url, String userName, String password){
        this.driver = driver;
        this.url = url;
        this.userName = userName;
        this.password = password;
    }*/
    public void connect() throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        conn = DriverManager.getConnection(url, userName, password);
    }

    public void disconnect() throws SQLException {
        if (rs != null && !rs.isClosed()) {
            rs.close();
            rs = null;
        }
        if (stmt != null && !stmt.isClosed()) {
            stmt.close();
            stmt = null;
        }
        if (conn != null && !conn.isClosed()) {
            conn.close();
            conn = null;
        }
    }

    public MemberDO getMemberDO(String uid, String upass) {
        MemberDO memberdo = new MemberDO();  // 회원 정보 DTO 객체 생성
        String query = "SELECT * FROM MEMBER WHERE EMAIL=? AND PWD=?";  // 쿼리문 템플릿

        try {
            // 쿼리 실행
            stmt = conn.prepareStatement(query); // 동적 쿼리문 준비
            stmt.setString(1, uid);    // 쿼리문의 첫 번째 인파라미터에 값 설정
            stmt.setString(2, upass);  // 쿼리문의 두 번째 인파라미터에 값 설정
            rs = stmt.executeQuery();  // 쿼리문 실행

            // 결과 처리
            if (rs.next()) {
                // 쿼리 결과로 얻은 회원 정보를 DTO 객체에 저장
                memberdo.setEmail(rs.getString("email"));
                memberdo.setPwd(rs.getString("pwd"));
                memberdo.setName(rs.getString(3));
                System.out.println(memberdo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return memberdo;
    }

    public List<MemberDO> getMemberViewList(String query){
        List<MemberDO> list = null;
        String sql = "SELECT * FROM MEMBER";
        try {
            connect();

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%"+query+"%");

            rs = stmt.executeQuery();
            if (rs.isBeforeFirst()) {
                list = new ArrayList<MemberDO>();
                while (rs.next()) {
                    MemberDO member = new MemberDO();
                    member.setId(rs.getInt("ID"));
                    member.setEmail(rs.getString("EMAIL"));
                    member.setPwd(rs.getString("PWD"));
                    member.setName(rs.getString("NAME"));
                    member.setGender(rs.getString("GENDER"));
                    member.setBirthday(rs.getString("BIRTHDAY"));
                    member.setPhone(rs.getString("PHONE"));
                    member.setRegdate(rs.getString("REGDATE"));
                    list.add(member);
                }
            }
            if (list != null) {
                for (MemberDO member : list) {
                    System.out.println(member);  // MemberDO의 toString() 메소드가 필요함
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                disconnect();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return list;
    }

    // insert
    public int insertMember(MemberDO member) {
        String sql = "INSERT INTO MEMBER (EMAIL, PWD, NAME, GENDER, BIRTHDAY, PHONE) " +
                "VALUES (?, ?, ?, ?, ?, ?) ";

        int result = 0;

        try {
            connect();

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, member.getEmail());
            stmt.setString(2, member.getPwd());
            stmt.setString(3, member.getName());
            stmt.setString(4, member.getGender());
            stmt.setString(5, member.getBirthday());
            stmt.setString(6, member.getPhone());

            result = stmt.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                disconnect();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return result;
    }

    // delete
    public int deleteMember(Integer id) {
        int result = 0;

        String sql = "DELETE FROM MEMBER WHERE ID = ?";

        try {
            connect();

            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            result = stmt.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                disconnect();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public MemberDO getMember(String email) {
        MemberDO memberDO = null;
        String sql = "SELECT * FROM MEMBER Where email=?";

        try {
            connect();

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            rs = stmt.executeQuery();

            while(rs.next()) {
                memberDO = new MemberDO();
                memberDO.setId(rs.getInt("ID"));
                memberDO.setEmail(rs.getString("EMAIL"));
                memberDO.setPwd(rs.getString("PWD"));
                memberDO.setName(rs.getString("NAME"));
                memberDO.setGender(rs.getString("GENDER"));
                memberDO.setBirthday(rs.getString("BIRTHDAY"));
                memberDO.setPhone(rs.getString("PHONE"));
                memberDO.setRegdate(rs.getString("REGDATE"));
                System.out.println(memberDO);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                disconnect();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //TODO :: 디비 접속 conn

        //todo :: select * FROM Member, MemeberDO 값들 setting
        return memberDO;
    }

    @Override
    public NotifyDO getNotify() {
        NotifyDO notifyDO = null;
        String sql = "SELECT * FROM NOTIFY";

        try {
            connect();

            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            if (rs.next()) {
                notifyDO = new NotifyDO();
                notifyDO.setNotify_id(rs.getString("notify_id"));
                notifyDO.setNotify_title(rs.getString("notify_title"));
                notifyDO.setNotify_content(rs.getString("notify_content"));
                notifyDO.setNotify_regdate(rs.getString("notify_regdate"));
                notifyDO.setMember_id(rs.getInt("member_id"));
                System.out.println(notifyDO);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                disconnect();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return notifyDO;
    }

    @Override
    public FortuneDO getFortune() {
        FortuneDO fortuneDO = null;
        String sql = "SELECT * FROM FORTUNE";

        try {
            connect();

            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            if (rs.next()) {
                fortuneDO = new FortuneDO();
                fortuneDO.setFortune_id(rs.getString("fortune_id"));
                fortuneDO.setFortune_variety(rs.getString("fortune_variety"));
                fortuneDO.setFortune_content(rs.getString("fortune_content"));
                fortuneDO.setFortune_date(rs.getString("fortune_date"));
                fortuneDO.setFortune_state(rs.getString("fortune_state"));
                fortuneDO.setMember_id(rs.getInt("member_id"));
                System.out.println(fortuneDO);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                disconnect();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return fortuneDO;
    }

    @Override
    public MemberDO getMemberDO(Integer memberId) {
        MemberDO memberdo = new MemberDO();
        String query = "SELECT * FROM MEMBER WHERE ID = ?";

        try {
            connect();

            stmt = conn.prepareStatement(query);
            stmt.setInt(1, memberId);
            rs = stmt.executeQuery();

            if (rs.next()) {
                memberdo.setId(rs.getInt("id"));
                memberdo.setEmail(rs.getString("email"));
                memberdo.setPwd(rs.getString("pwd"));
                memberdo.setName(rs.getString("name"));
                memberdo.setGender(rs.getString("gender"));
                memberdo.setBirthday(rs.getString("birthday"));
                memberdo.setPhone(rs.getString("phone"));
                memberdo.setRegdate(rs.getString("regdate"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                disconnect();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return memberdo;
    }

    @Override
    public FortuneDO getFortune(String fortuneId) {
        FortuneDO fortuneDO = new FortuneDO();
        String query = "SELECT * FROM FORTUNE WHERE FORTUNE_ID = ?";

        try {
            connect();

            stmt = conn.prepareStatement(query);
            stmt.setString(1, fortuneId);
            rs = stmt.executeQuery();

            if (rs.next()) {
                fortuneDO.setFortune_id(rs.getString("fortune_id"));
                fortuneDO.setFortune_variety(rs.getString("fortune_variety"));
                fortuneDO.setFortune_content(rs.getString("fortune_content"));
                fortuneDO.setFortune_date(rs.getString("fortune_date"));
                fortuneDO.setFortune_state(rs.getString("fortune_state"));
                fortuneDO.setMember_id(rs.getInt("member_id"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                disconnect();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return fortuneDO;
    }

    @Override
    public NotifyDO getNotify(String notifyId) {
        NotifyDO notifyDO = new NotifyDO();
        String query = "SELECT * FROM NOTIFY WHERE NOTIFY_ID = ?";

        try {
            connect();

            stmt = conn.prepareStatement(query);
            stmt.setString(1, notifyId);
            rs = stmt.executeQuery();

            if (rs.next()) {
                notifyDO.setNotify_id(rs.getString("notify_id"));
                notifyDO.setNotify_title(rs.getString("notify_title"));
                notifyDO.setNotify_content(rs.getString("notify_content"));
                notifyDO.setNotify_regdate(rs.getString("notify_regdate"));
                notifyDO.setMember_id(rs.getInt("member_id"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                disconnect();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return notifyDO;
    }

    @Override
    public int insertNotify(NotifyDO notify) {
        String sql = "INSERT INTO NOTIFY (NOTIFY_ID, NOTIFY_TITLE, NOTIFY_CONTENT, NOTIFY_REGDATE, MEMBER_ID) " +
                "VALUES (?, ?, ?, CURRENT_TIMESTAMP, ?)";

        int result = 0;

        try {
            connect();

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, notify.getNotify_id());
            stmt.setString(2, notify.getNotify_title());
            stmt.setString(3, notify.getNotify_content());
            stmt.setInt(4, notify.getMember_id());

            result = stmt.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                disconnect();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public int deleteNotify(String notifyId) {
        int result = 0;

        String sql = "DELETE FROM NOTIFY WHERE NOTIFY_ID = ?";

        try {
            connect();

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, notifyId);

            result = stmt.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                disconnect();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public int insertFortune(FortuneDO fortune) {
        String sql = "INSERT INTO FORTUNE (FORTUNE_ID, FORTUNE_VARIETY, FORTUNE_CONTENT, FORTUNE_DATE, FORTUNE_STATE, MEMBER_ID) " +
                "VALUES (?, ?, ?, CURRENT_TIMESTAMP, ?, ?)";

        int result = 0;

        try {
            connect();

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, fortune.getFortune_id());
            stmt.setString(2, fortune.getFortune_variety());
            stmt.setString(3, fortune.getFortune_content());
            stmt.setString(4, fortune.getFortune_state());
            stmt.setInt(5, fortune.getMember_id());

            result = stmt.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                disconnect();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public int deleteFortune(String fortuneId) {
        int result = 0;

        String sql = "DELETE FROM FORTUNE WHERE FORTUNE_ID = ?";

        try {
            connect();

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, fortuneId);

            result = stmt.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                disconnect();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return result;
    }
}
