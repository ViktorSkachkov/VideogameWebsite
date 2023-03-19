import {Link} from "react-router-dom";
import '../css/Navigation.css';
import {useState, useEffect} from "react";

const Navigation = (removeUser) => {
    const [roles, setRoles] = useState([]);
   // const [dropdownTitles, setDropdownTitles] = ["Profile", "Settings", "Log Out"]
    const [id, setId] = useState(0);

    useEffect(() => {
        getRoles();
    }, []);

    const getRoles = () => {
        let token_deserialized = JSON.parse(localStorage.getItem("token"));
        if(token_deserialized != null) {
            setRoles(token_deserialized.userRoles.map(element => element.role));
            setId(token_deserialized.id);
        }
        console.log(token_deserialized);
    }

    return (
        <nav className="navBar">
            <div>
                <img src="/69piR5.jpg" height="50px" width="100px" alt=""/>
            </div>
            {roles.length == 0 ?
                <>
                    <div className='navLinks'>
                        <Link to="/">Home</Link>
                        <Link to="/logIn">LogIn</Link>
                        <Link to="/register">Register</Link>
                    </div>
                    <div>

                    </div>
                </> : <>
                <div className='navLinks'>
                <Link to="/">Home</Link>
                <Link to="/games">Games</Link>
                <Link to="/shop">Shop</Link>
                <Link to="/news">News</Link>
            </div>
            <div>
                <Link to="/support">Support</Link>
                <Link to={`/profile/${id}`}>Profile</Link>
                <Link to="/" onClick={removeUser.removeUser}>LogOut</Link>
            </div></>}
        </nav>
    )
};

export default Navigation;