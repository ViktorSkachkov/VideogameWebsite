import {useNavigate} from "react-router-dom";
import axios from "axios";
import Cookies from "universal-cookie";

const NewsArticleCardAdmin = (newsArticle) => {
    let navigate = useNavigate();

    const cookies = new Cookies();
    const token = cookies.get("accessToken");

    function deleteNewsArticle(id) {
        var config = {
            method: "delete",
            url: `http://localhost:8080/news/${id}`,
            headers: {
                "Authorization": `Bearer ${token}`,
            },
        };
        axios(config)
            .then(function (response) {
                alert('News article successfully deleted!');
            })
            .catch(function (error) {
                console.log(error);
            });
    }

    return (
        <div className="newsArticleCard">
            <div>
                <img src="69piR5.jpg" height="300px" width="450px" alt=""/>
            </div>
            <div>
                <h1>{newsArticle.newsArticle.title}</h1>
                <p className="text">{newsArticle.newsArticle.text}</p>
                <button onClick={() => deleteNewsArticle(newsArticle.newsArticle.id) }>Remove</button> <button onClick={() => {
                navigate(`/updateNewsArticle/${newsArticle.newsArticle.id}`, {

                });
            }}>Update</button>
            </div>
        </div>
    )
}
export default NewsArticleCardAdmin;