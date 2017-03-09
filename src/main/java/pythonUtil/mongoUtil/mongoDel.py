from pymongo import MongoClient
import bson
import collections
from bson.codec_options import CodecOptions
client = MongoClient()
db = client.JD
coll=db.Friso_1
doc = db.Friso_1.find_one()
comments=[]
comments=doc['comments']
for comment in comments:
    dic={}
    print(comment['content'])
    comment['content']


