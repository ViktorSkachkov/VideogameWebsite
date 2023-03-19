import {useState} from "react";
import '../css/Register.css';

const Register = () => {
    const [username, setUsername] = useState("");
    const [pwd, setPwd] = useState("");
    const [repeatPwd, setRepeatPwd] = useState("");
    const [email, setEmail] = useState("");
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
    const handleSubmit = (e) => {

    }
    return (
        <>
            <center><br/><br/>
            <h1>
                REGISTER
            </h1>
            <p>Fill in your personal information</p><br/>
            <form onSubmit={handleSubmit}>
                <label htmlFor="username" className="formLabelUsername">Username</label><br/>
                <input type="text" onChange={onChangeUsername} className="Label"/><br/><br/>

                <label htmlFor="password" className="formLabelPassword">Password</label><br/>
                <input type="password" onChange={onChangePwd} className="Label"/><br/><br/>

                <label htmlFor="repeatPassword" className="formLabelRepeatPassword">Repeat Password</label><br/>
                <input type="password" onChange={onChangeRepeatPwd} className="Label"/><br/><br/>

                <label htmlFor="email" className="formLabelEmail">Email</label><br/>
                <input type="email" onChange={onChangeEmail} className="Label"/><br/><br/>

                <button type="submit" className="normalButton">Submit</button><br/><br/><br/><br/><br/><br/><br/>
            </form>
            </center>
        </>
    )
}
export default Register;