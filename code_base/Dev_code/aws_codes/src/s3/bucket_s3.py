import boto3

# all_regions = [
# 'us-east-1', 'us-west-1', 'us-west-2', 'us-east2', 'eu-west-1',
# 'eu-west-2', 'eu-central-1','eu-north-1', 'eu-south-1',
# 'ap-southeast-1', 'ap-southeast-2', 'ap-south-1', 'sa-east-1']

client = boto3.client("ec2")
all_regions = regions = client.describe_regions()

for region in all_regions["Regions"][0]["RegionName"]:
    # def_vpc = client.create_default_vpc()
    # print(def_vpc)

    desc_resp = client.describe_vpcs(
        Filters=[
            {
                "Name": "isDefault",
                "Values": [
                    "True",
                ],
            },
        ]
    )
    print(desc_resp)
