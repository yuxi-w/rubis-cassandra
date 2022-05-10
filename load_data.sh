#load transformed data to Cassandra.

cqlsh localhost < rubis_create.cql
cqlsh localhost -k rubis < rubis_CF_schema.cql

dsbulk load -h localhost  -k rubis -t users -url dataset/users.csv
dsbulk load -h localhost  -k rubis -t categories -url dataset/categories.csv
dsbulk load -h localhost  -k rubis -t items -url dataset/items.csv
dsbulk load -h localhost  -k rubis -t bids_users -url dataset/bids_users.csv
dsbulk load -h localhost  -k rubis -t comments_users -url dataset/comments_users.csv
dsbulk load -h localhost  -k rubis -t buynow_items -url dataset/buynow_items.csv
dsbulk load -h localhost  -k rubis -t bids_items -url dataset/bids_items.csv
dsbulk load -h localhost  -k rubis -t users_items -url dataset/users_items.csv
dsbulk load -h localhost  -k rubis -t regions -url dataset/regions.csv