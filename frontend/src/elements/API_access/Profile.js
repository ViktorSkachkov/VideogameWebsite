import axios from "axios";
import {useEffect, useState} from "react";
import {useNavigate, useParams} from "react-router-dom";
import Cookies from "universal-cookie";


const Profile = (updateUser=updateUser, removeUser=removeUser) => {
    const [user, setUser] = useState(null);
    const [username, setUsername] = useState("");
    const [pwd, setPwd] = useState("");
    const [repeatPwd, setRepeatPwd] = useState("");
    const [email, setEmail] = useState("");
    const [bankAccount, setBankAccount] = useState("");

    let params = useParams();
    const id = params.id;

    let navigate = useNavigate();

    const cookies = new Cookies();
    const token = cookies.get("accessToken");

    useEffect(() => {
        getUser();
    }, []);
    const updateProfile = (e) => {
        e.preventDefault();
        if(pwd != repeatPwd) {
            alert('The password and the repeated password are different!');
        }
        const config = {
            headers: { Authorization: `Bearer ${token}` }
        };
        const bodyParams = {
            "id": id,
            "username": username,
            "pwd": pwd,
            "email": email,
            "bankAccount": bankAccount,
            "userRoles": user.userRoles,
        };
        axios.put(
            `http://localhost:8080/users`,
            bodyParams,
            config
        )
            .then(function (response) {
                setUser(response.data);
                cookies.set("accessToken", response.data.accessToken, { path: '/' });
                updateUser.updateUser();
                //changeSession(username, pwd);
            })
            .catch(function (error) {
                console.log(error);
            });
    };

    function deleteProfile(userId) {
        var config = {
            method: "delete",
            url: `http://localhost:8080/users/${userId}`,
            headers: {
                "Authorization": `Bearer ${token}`,
            },
        };
        axios(config)
            .then(function (response) {
                localStorage.removeItem("token");
                navigate("/");
                window.location.reload();
            })
            .catch(function (error) {
                console.log(error);
            });
    }

    const getUser = () => {
        var config = {
            method: "get",
            url: `http://localhost:8080/users/${id}`,
            headers: {
                "Authorization": `Bearer ${token}`,
            },
        };
        axios(config)
            .then(function (response) {
                let {username, pwd, email, bankAccount} = response.data;
                setRepeatPwd(pwd);
                setPwd(pwd);
                setUsername(username);
                setEmail(email);
                setBankAccount(bankAccount);
                setUser(response.data);
            })
            .catch(function (error) {
                console.log(error);
            });
    };

    /*function changeSession(loginUsername, loginPassword) {
        //e.preventDefault();
        const cookies = new Cookies();
        var data = JSON.stringify({
            "username": loginUsername,
            "password": "SomePassword"
        });

        var config = {
            method: 'post',
            url: 'http://localhost:8080/login',
            headers: {
                'Content-Type': 'application/json'
            },
            data: data
        };


        axios(config)
            .then(function (response) {
                cookies.set("accessToken", response.data.accessToken, { path: '/' });
                updateUser.updateUser();
                //navigate("/");
            })
            .catch(function (error) {
                alert("Incorrect login details");
            });
    }*/

    const onChangeUsername = event => {
        setUsername(event.target.value);
    }
    const onChangePwd = event => {
        setPwd(event.target.value);
    }
    const onChangeRepeatPwd = event => {
        setRepeatPwd(event.target.value);
    }
    const onChangeEmail = event => {
        setEmail(event.target.value);
    }
    const onBankAccount = event => {
        setBankAccount(event.target.value);
    }

    return (
        <>
        {user != null ? <>
            <center><br/><br/>
                <h1>
                    Your Profile! Welcome {username}
                </h1>
                <h3>Fill in your personal information</h3>
                <p>Due to security measures you will not be able to see your password.</p><br/>

                <form onSubmit={updateProfile}>
                    <label htmlFor="username" className="formLabelUsername">Username</label><br/>
                    <input type="text" value={username} onChange={onChangeUsername} className="Label"/><br/><br/>

                    <label htmlFor="password" className="formLabelPassword">Password</label><br/>
                    <input type="password" value={pwd} onChange={onChangePwd} className="Label"/><br/><br/>

                    <label htmlFor="repeatPassword" className="formLabelRepeatPassword">Repeat Password</label><br/>
                    <input type="password" value={repeatPwd} onChange={onChangeRepeatPwd} className="Label"/><br/><br/>

                    <label htmlFor="email" className="formLabelEmail">Email</label><br/>
                    <input type="email" value={email} onChange={onChangeEmail} className="Label"/><br/><br/>

                    <label htmlFor="bankAccount" className="formLabelBankAccount">Bank Account</label><br/>
                    <input type="bankAccount" value={bankAccount} onChange={onBankAccount} className="Label"/><br/><br/>

                    <button type="submit" className="normalButton">Update Account<br/> Information</button><br/><br/>
                </form>
                <button onClick={() => deleteProfile(id)}>Delete Account</button><br/><br/><br/>
            </center>
        </> : <></>}
        </>

    )
}
export default Profile;