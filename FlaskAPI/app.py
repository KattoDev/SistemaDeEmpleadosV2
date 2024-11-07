from flask import Flask
from config import Config
from models import db

from routes.blueprints.user import user_bp

app = Flask(__name__)

app.config.from_object(Config)

db.init_app(app)

app.register_blueprint(user_bp, url_prefix="/api/users")

if __name__ == "__main__":
    with app.app_context():
        db.create_all()
    app.run(debug=True)
