package kr.co.dinner41.mapper;

import kr.co.dinner41.vo.*;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class ReviewMapper implements RowMapper<ReviewVO> {
    @Override
    public ReviewVO mapRow(ResultSet rs, int rowNum) throws SQLException {
        int id = rs.getInt("review_id");

        int storeId= rs.getInt("store_id");
        int userId=rs.getInt("user_id");
        String storeCategoryId=rs.getString("store_category_id");
        int storeStateId=rs.getInt("store_state_id");
        String storeBusinessNumber=rs.getString("store_business_number");
        String storeName=rs.getString("store_name");
        String storeAddress=rs.getString("store_address");
        String storeSubAddress=rs.getString("store_sub_address");
        double storeLatitude=rs.getDouble("store_latitude");
        double storeLongitude=rs.getDouble("store_longitude");
        String storePhone=rs.getString("store_phone");
        String storeOperateTime=rs.getString("store_operate_time");
        String storePhoto=rs.getString("store_photo");
        String storeIntroduction= rs.getString("store_introduction");
        OpenState storeOpenState = OpenState.valueOf(rs.getString("store_open_state"));
        String storePayNumber= rs.getString("store_paynumber");

        String userTypeId = rs.getString("user_type_id");
        String userTypeName= rs.getString("user_type_name");
        UserTypeVO userType = new UserTypeVO(userTypeId,userTypeName);

        String userEmail=rs.getString("user_email");
        String userPassword=rs.getString("user_password");
        String userName=rs.getString("use_name");
        String userAddress=rs.getString("user_address");
        String userSubAddress=rs.getString("user_sub_address");
        double userLatitude=rs.getDouble("user_latitude");
        double userLongitude=rs.getDouble("user_longitude");
        String userPhone=rs.getString("user_phone");
        Timestamp userRegisterDate=rs.getTimestamp("user_register_date");
        Timestamp userRemoveDate=rs.getTimestamp("user_remove_date");
        UserVO user = new UserVO(userId,userType,userEmail,userPassword,userName,userAddress,userSubAddress,
                userLatitude,userLongitude,userPhone,userRegisterDate,userRemoveDate);

        String storeCategoryName = rs.getString("store_category_name");
        StoreCategoryVO storeCategory = new StoreCategoryVO(storeCategoryId,storeCategoryName);

        String storeStateName= rs.getString("store_state_name");
        StoreStateVO storeState = new StoreStateVO(storeStateId,storeStateName);

        StoreVO store = new StoreVO(storeId,user,storeCategory,storeState,storeBusinessNumber,storeName,storeAddress,storeSubAddress,
                storeLatitude,storeLongitude,storePhone,storeOperateTime,storePhoto,storeIntroduction,storeOpenState,storePayNumber);

        int user_id = rs.getInt("user_id");
        String user_type_id = rs.getString("user_type_id");
        String user_type_name = rs.getString("user_type_name");
        UserTypeVO user_type = new UserTypeVO(user_type_id, user_type_name);
        String user_email = rs.getString("user_email");
        String user_password = rs.getString("user_password");
        String user_name = rs.getString("user_name");
        String user_address = rs.getString("user_address");
        String user_subAddress = rs.getString("user_sub_address");
        double user_latitude = rs.getDouble("user_latitude");
        double user_longitude = rs.getDouble("user_longitude");
        String user_phone = rs.getString("user_phone");
        Timestamp user_registerDate = rs.getTimestamp("user_register_date");
        Timestamp user_removeDate = rs.getTimestamp("user_remove_date");
        UserVO user_vo = new UserVO(user_id, user_type, user_email, user_password, user_name, user_address, user_subAddress, user_latitude, user_longitude, user_phone, user_registerDate, user_removeDate);


        String content = rs.getString("review_content");
        int score = rs.getInt("review_score");
        Timestamp date = rs.getTimestamp("review_date");

        return new ReviewVO(id, store, user_vo, score, content, date);
    }
}
