import VideogameCard from "./VideogameCard";
import {useState, useEffect} from "react";
import NewsArticleCard from "./NewsArticleCard";
import '../css/News.css';
import axios from "axios";
import VideogameCardAdmin from "./VideogameCardAdmin";
import NewsArticleCardAdmin from "./NewsArticleCardAdmin";
import {useNavigate} from "react-router-dom";
import Cookies from "universal-cookie";

const News = (loggedUser) => {
    const [newsArticles, setNewsArticles] = useState([]);
    const [roles, setRoles] = useState([]);

    let navigate = useNavigate();

    const cookies = new Cookies();
    const token = cookies.get("accessToken");

    useEffect(() => {
        getRoles();
        getVideogames();
    }, []);

    const getRoles = () => {
        let token_deserialized = JSON.parse(localStorage.getItem("token"));
        if(token_deserialized != null) {
            setRoles(token_deserialized.userRoles.map(element => element.role));
        }
    }

    const getVideogames = () => {
        var config = {
            method: "get",
            url: `http://localhost:8080/news`,
            headers: {
                "Authorization": `Bearer ${token}`,
            },
        };
        axios(config)
            .then(function (response) {
                setNewsArticles(response.data);
            })
            .catch(function (error) {
                console.log(error);
            });
    }

    return (
        <>
            <center>
                <h1 className="title">NEWS</h1>
                <h3 className="title">Filters</h3>
                {roles.some(r => r == "EMPLOYEE") ?
                    <> <div className="listOfNewsArticles">
                        {newsArticles.map((newsArticle) => (
                            <NewsArticleCardAdmin newsArticle={newsArticle} />
                        ))}
                    </div>
                        <button onClick={() => {
                            navigate(`/addNewsArticle`, {
                            });
                        }}>Add News Article</button>
                    </> : roles.some(r => r == "CUSTOMER") ?
                        <div className="listOfNewsArticles">
                            {newsArticles.map((newsArticle) => (
                                <NewsArticleCard newsArticle={newsArticle} />
                            ))}
                        </div> : <></>
                }
            </center><br/>
        </>
    )
}
export default News;