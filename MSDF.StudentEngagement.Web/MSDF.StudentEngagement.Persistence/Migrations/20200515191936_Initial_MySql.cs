﻿using System;
using Microsoft.EntityFrameworkCore.Migrations;
using MySql.Data.EntityFrameworkCore.Metadata;

namespace MSDF.StudentEngagement.Persistence.Migrations
{
    public partial class Initial_MySql : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.CreateTable(
                name: "LearningApp",
                columns: table => new
                {
                    LearningAppIdentifier = table.Column<string>(maxLength: 60, nullable: false),
                    Namespace = table.Column<string>(maxLength: 255, nullable: true),
                    Description = table.Column<string>(maxLength: 1024, nullable: true),
                    Website = table.Column<string>(maxLength: 255, nullable: true),
                    AppUrl = table.Column<string>(maxLength: 255, nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_LearningApp", x => x.LearningAppIdentifier);
                });

            migrationBuilder.CreateTable(
                name: "StudentInformation",
                columns: table => new
                {
                    Id = table.Column<int>(nullable: false)
                        .Annotation("MySQL:ValueGenerationStrategy", MySQLValueGenerationStrategy.IdentityColumn),
                    StudentUSI = table.Column<int>(nullable: false),
                    StudentUniqueId = table.Column<string>(maxLength: 32, nullable: true),
                    StudentStateIdentificationCode = table.Column<string>(maxLength: 60, nullable: true),
                    IdentityElectronicMailAddress = table.Column<string>(maxLength: 60, nullable: true),
                    DeviceId = table.Column<string>(maxLength: 100, nullable: true),
                    LocalEducationAgencyName = table.Column<string>(maxLength: 75, nullable: true),
                    SchoolName = table.Column<string>(maxLength: 75, nullable: true),
                    SchoolYear = table.Column<string>(maxLength: 15, nullable: true),
                    SchoolCurrentGradeLevelDescriptorCodeValue = table.Column<string>(maxLength: 50, nullable: true),
                    SchoolTypeDescriptorCodeValue = table.Column<string>(maxLength: 50, nullable: true),
                    ExitWithdrawalDate = table.Column<DateTime>(nullable: false),
                    FirstName = table.Column<string>(maxLength: 75, nullable: true),
                    MiddleName = table.Column<string>(maxLength: 75, nullable: true),
                    LastSurname = table.Column<string>(maxLength: 75, nullable: true),
                    BirthDate = table.Column<DateTime>(nullable: false),
                    BirthSexDescriptorCodeValue = table.Column<string>(maxLength: 50, nullable: true),
                    Ethnicity = table.Column<string>(maxLength: 25, nullable: true),
                    Race_AmericanIndianAlaskanNative = table.Column<bool>(nullable: true),
                    Race_Asian = table.Column<bool>(nullable: true),
                    Race_BlackAfricaAmerican = table.Column<bool>(nullable: true),
                    Race_NativeHawaiianPacificIslander = table.Column<bool>(nullable: true),
                    Race_White = table.Column<bool>(nullable: true),
                    Race_ChooseNotToRespond = table.Column<bool>(nullable: true),
                    Race_Other = table.Column<bool>(nullable: true),
                    DisabilityStatusDescriptorCodeValue = table.Column<string>(maxLength: 50, nullable: true),
                    EconomicallyDisadvantageDescriptorCodeValue = table.Column<string>(maxLength: 50, nullable: true),
                    ELLStatusDescriptorCodeValue = table.Column<string>(maxLength: 50, nullable: true),
                    MigrantDescriptorCodeValue = table.Column<string>(maxLength: 50, nullable: true),
                    HomelessDescriptorCodeValue = table.Column<string>(maxLength: 50, nullable: true),
                    FosterDescriptorCodeValue = table.Column<string>(maxLength: 50, nullable: true),
                    F504DescriptorCodeValue = table.Column<string>(maxLength: 50, nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_StudentInformation", x => x.Id);
                });

            migrationBuilder.CreateTable(
                name: "StudentLearningEventLog",
                columns: table => new
                {
                    Id = table.Column<long>(nullable: false)
                        .Annotation("MySQL:ValueGenerationStrategy", MySQLValueGenerationStrategy.IdentityColumn),
                    StudentUSI = table.Column<int>(nullable: false),
                    StudentUniqueId = table.Column<string>(maxLength: 32, nullable: true),
                    DeviceId = table.Column<string>(maxLength: 32, nullable: true),
                    StudentElectronicMailAddress = table.Column<string>(maxLength: 128, nullable: true),
                    IPAddress = table.Column<string>(maxLength: 15, nullable: true),
                    ReffererUrl = table.Column<string>(maxLength: 1024, nullable: true),
                    LeaningAppUrl = table.Column<string>(maxLength: 1024, nullable: true),
                    UTCStartDate = table.Column<DateTime>(nullable: false),
                    UTCEndDate = table.Column<DateTime>(nullable: true),
                    TimeSpent = table.Column<int>(nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_StudentLearningEventLog", x => x.Id);
                });
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropTable(
                name: "LearningApp");

            migrationBuilder.DropTable(
                name: "StudentInformation");

            migrationBuilder.DropTable(
                name: "StudentLearningEventLog");
        }
    }
}