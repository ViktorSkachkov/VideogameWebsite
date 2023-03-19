import {useState} from "react";
import Cookies from "universal-cookie";
import {useNavigate} from "react-router-dom";
import axios from "axios";

const LogIn = (updateUser) => {
    const [username, setUsername] = useState("");
    const [pwd, setPwd] = useState("");

    let navigate = useNavigate();

    const onChangeUsername = event => {
        setUsername(event.target.value);
    }
    const onChangePwd = event => {
        setPwd(event.target.value);
    }
    const handleSubmit = (e) => {
        e.preventDefault();
        const cookies = new Cookies();
        var data = JSON.stringify({
            "username": username,
            "password": pwd
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
                navigate("/");
                //window.location.reload();
            })
            .catch(function (error) {
                alert("Incorrect login details");
            });
    }
    return (
        <>
            <center><br/><br/>
            <h1>
                LOGIN
            </h1>
            <p>Fill in your personal information</p><br/>
            <form onSubmit={handleSubmit}>
                <label htmlFor="username" className="formLabelUsername">Username</label><br/>
                <input type="text" name="username" onChange={onChangeUsername} className="Label"/><br/><br/>
                <label htmlFor="password" className="formLabelPassword">Password</label><br/>
                <input type="password" name="password" onChange={onChangePwd} className="Label"/>
                <br/><br/>
                <button type="submit" className="normalButton">Submit</button><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
            </form>
            </center>
        </>
    )
}
export default LogIn;