package com.example.demo.dao;

import com.example.demo.domain.Member;
import com.example.demo.domain.MemberDO;

import java.security.PublicKey;
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
                    member.setId(rs.getString("ID"));
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
    @Override
    public MemberDO getMember() {
        MemberDO memberDO = null;
        String sql = "SELECT * FROM MEMBER";

        try {
            connect();

            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            if (rs.next()) {
                memberDO = new MemberDO();
                memberDO.setId(rs.getString("ID"));
                memberDO.setPwd(rs.getString("PWD"));
                memberDO.setName(rs.getString("NAME"));
                memberDO.setGender(rs.getString("GENDER"));
                memberDO.setBirthday(rs.getString("BIRTHDAY"));
                memberDO.setPhone(rs.getString("PHONE"));
                System.out.println(memberDO);
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

        //TODO :: 디비 접속 conn

        //todo :: select * FROM Member, MemeberDO 값들 setting


        return memberDO;
    }
}
