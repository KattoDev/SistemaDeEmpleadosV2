class Config:
    user = "API"
    password = "localstaticvoid__3306"
    host = "localhost"
    port = 3306
    database = "SistemaDeEmpleados"

    SQLALCHEMY_DATABASE_URI = (
        f"mysql+pymysql://{user}:{password}@{host}:{port}/{database}"
    )
    SQLALCHEMY_TRACK_MODIFICATIONS = False
